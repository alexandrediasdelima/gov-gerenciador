package br.com.experian.gerenciadorperfil.core.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.experian.gerenciadorperfil.core.entity.filter.AbstractEntityFilter;

public final class EntityUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(EntityUtils.class);

	public static void copyProperties(final Object destino, final Object origem) {
		try {
			IntegerConverter integerConverter = new IntegerConverter(null);
			DateConverter dateConverter = new DateConverter(null);
			LongConverter longConverter = new LongConverter(null);
			BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
			beanUtilsBean.getConvertUtils().register(integerConverter, Integer.class);
			beanUtilsBean.getConvertUtils().register(longConverter, Long.class);
			beanUtilsBean.getConvertUtils().register(dateConverter, Date.class);
			beanUtilsBean.copyProperties(destino, origem);
		} catch (Exception e) {
			String message = "Erro ao copiar proriedades entre objetos";
			LOGGER.error(message, e);
			throw new IllegalArgumentException(message, e);
		}
	}

	public static <Filter extends AbstractEntityFilter<?, Filter>> Filter createFilter(final Class<Filter> filterClass) {
		Filter filter;
		try {
			filter = filterClass.newInstance();
		} catch (Exception e) {
			String message = "Erro ao criar filtro do tipo " + filterClass.getName();
			LOGGER.error(message, e);
			throw new IllegalArgumentException(message, e);
		}
		return filter;
	}

	public static Object getPrimaryKey(final Object bean) {

		try {
			List<Field> fields = getField(bean, Id.class);
			if (fields.isEmpty()) {
				fields = getField(bean, EmbeddedId.class);
			}
			if (fields.isEmpty()) {
				String message = "O bean nao tem chave configurada " + bean.getClass().getName();
				LOGGER.error(message);
				throw new IllegalArgumentException(message);
			} else {
				Object result = getObjectProprety(bean, fields.get(0).getName());
				if (result instanceof Number && ((Number) result).doubleValue() == 0) {
					result = null;
				}
				return result;
			}
		} catch (Exception exception) {
			String message = "Nao foi possivel recuperar a chave do objeto";
			LOGGER.error(message);
			throw new IllegalArgumentException(message, exception);
		}
	}

	private static Object getObjectProprety(final Object bean, final String propertyName) {
		try {
			Method method = findGetter(bean, propertyName);
			Object value = null;
			if (method != null) {
				value = method.invoke(bean);
			}
			return value;
		} catch (Exception e) {
			String message = "Nao achou a propriedade " + propertyName;
			LOGGER.error(message);
			throw new IllegalArgumentException(message, e);
		}
	}

	private static Method findGetter(final Object bean, final String propertyName) {
		Class<? extends Object> beanClass = bean.getClass();
		return findGetter(beanClass, propertyName);
	}

	private static Method findGetter(final Class<? extends Object> beanClass, final String propertyName) {
		Method method = null;
		String capitalized = capitalize(propertyName);
		for (Class<?> current = beanClass; !current.equals(Object.class) && method == null; current = current.getSuperclass()) {
			try {
				method = current.getMethod("get" + capitalized);
			} catch (Exception e) {
				// Nothing ... As vezes o campo pode estar na classe de cima ...
			}
		}
		return method;
	}

	/**
	 * Créditos ao StringUtils da apache
	 * @param str
	 * @return
	 */
	private static String capitalize(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		return new StringBuffer(str.length())
			.append(Character.toTitleCase(str.charAt(0)))
			.append(str.substring(1))
			.toString();
	}

	private static List<Field> getField(final Object bean, final Class<? extends Annotation> annotation) {
		List<Field> fields = new ArrayList<Field>();
		for (Class<?> klass = bean.getClass(); !klass.equals(Object.class); klass = klass.getSuperclass()) {
			try {
				for (Field current : klass.getDeclaredFields()) {
					if (current.getAnnotation(annotation) != null) {
						fields.add(current);
					}
				}
			} catch (SecurityException securityException) {
				String message = "Nao foi possivel acessar o campo escolhido";
				LOGGER.error(message);
				throw new IllegalArgumentException(message, securityException);
			}
		}
		return fields;
	}

	public static String replaceAllSpecialCharacters(final String string) {
		return string.replaceAll("[^a-zA-Z0-9\\s%]", "_");
	}

	private EntityUtils() {

	}
}
