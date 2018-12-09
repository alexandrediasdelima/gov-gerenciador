package br.com.experian.gerenciadorperfil.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.resource.spi.security.PasswordCredential;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import br.com.experian.commons.environment.configuration.Environment;
import br.com.experian.commons.security.cryptography.business.CryptographyFactory;
import br.com.experian.commons.security.cryptography.datatype.Cryptography;
import br.com.experian.commons.security.user.User;

import com.ibm.wsspi.security.auth.callback.Constants;
import com.ibm.wsspi.security.auth.callback.WSMappingCallbackHandlerFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class CoreUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CoreUtils.class);
	
	public static final String DEFAULT_BUNDLE = "experian-gerenciador-perfil";
	
	public static final String DOCUMENTO_SERASA = "062173620";
	
	private CoreUtils() {
	}
	
	public static String processarFTL(String templateName, Map<String, Object> params, ClassLoader classLoader, String basePackagePath) {
		
		String result = null;
		Map<String, Object> dataModel = new HashMap<String, Object>();
		
		try {
			
			if(StringUtils.isNotBlank(templateName)) {
				
				if(classLoader != null) {
					
					if(params != null) {
						dataModel.putAll(params);
					}

					Configuration cfg = new Configuration(Configuration.getVersion());
					cfg.setClassLoaderForTemplateLoading(classLoader, basePackagePath);
					Template template = cfg.getTemplate(templateName, "UTF-8");

					StringWriter writer = new StringWriter();
					template.process(dataModel, writer);
					
					result = writer.toString();
					
					writer.flush();
					writer.close();
				}else{
					LOGGER.error("Nao foi possivel processar arquivo FTL: O ClassLoader nao pode ser nulo");
				}
			}else{
				LOGGER.error("Nao foi possivel processar arquivo FTL: O caminho do arquivo nao pode ser nulo ou vazio");
			}
		} catch (Exception e) {
			LOGGER.error("Ocorreu um erro ao processar arquivo FTL: ", e);
		}
		
		return result;
	}
	
	public static User safeGetApplicationUser() {
		
		try{
			
			String env = Environment.getInstance().getEnvironmentTO().getCurrentEnvironmentName();
			String cicsName = Environment.getInstance().getEnvironmentTO().getCics().getCicsDefaultName();
			Cryptography cryptographyTO = new Cryptography();
			String[] credencials = null;
			
			if(env.equalsIgnoreCase("LO")) {
				// TODO: PREENCHER LOGON E SENHA PARA RODAR LOCAL
				credencials = new String[2];
				credencials[0] = "skc3420";
				credencials[1] = "Kle#5332";
			}else{
				credencials = recuperarCredenciais(getProperty("application.user.alias"));
			}
			
			User user = new User();
			user.setUserLogin(credencials[0]);
			user.setUserCompanyDocument(DOCUMENTO_SERASA);
			
			cryptographyTO.setLoginName(credencials[0]);
			cryptographyTO.setPassword (credencials[1]);
			cryptographyTO.setCicsName (cicsName);
			
			user.setUserSessionParam(CryptographyFactory.getInstance().createCryptography(61).doCryption(cryptographyTO));
	
			return user;
			
		} catch(Exception e) {
			LOGGER.error("Ocorreu um erro ao obter autenticacao: ", e);
		}
	
		return null;
	}
	
	public static List<String> readLines(InputStream arquivo) throws IOException {
		
		String line = null;
		List<String> lines = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(arquivo));
		
		while((line = reader.readLine()) != null) {
			lines.add(line);
		}
		
		return lines;
	}
	
	public static <T> List<T> getAmountFromList(List<T> lista, int amount) {
		
		List<T> list = new ArrayList<T>();
		if(!CollectionUtils.isEmpty(lista)) {
			for(int i = 0; i < (lista.size() < amount ? lista.size() : amount); i++) {
				list.add(lista.get(i));
			}
		}
		
		return list;
	}
	
	public static String getProperty(String key) {
		
		try {
			
			String env = Environment.getInstance().getEnvironmentTO().getCurrentEnvironmentName();
			
			String bundle = DEFAULT_BUNDLE + "-" + env;
			
			ResourceBundle resourceBundle = ResourceBundle.getBundle(bundle, new Locale(""), CoreUtils.class.getClassLoader());
			
			return resourceBundle.getString(key);
			
		} catch (Exception e) {
			LOGGER.error("Nao foi possivel recuperar a string {}: ", key, e);
		}
		
		return null;
	}
	
	private static String[] recuperarCredenciais(String alias) throws Exception {
		
		String[] credencials = new String[2];
		
		Map<String, String> aliases = new HashMap<String, String>();
		aliases.put(Constants.MAPPING_ALIAS, alias);
		
		CallbackHandler callbackHandler = WSMappingCallbackHandlerFactory.getInstance().getCallbackHandler(aliases, null);
		
		LoginContext loginContext = new LoginContext("DefaultPrincipalMapping", callbackHandler);
		loginContext.login();
		
		Set<Object> credenciais = loginContext.getSubject().getPrivateCredentials();
		
		PasswordCredential cred = (PasswordCredential) credenciais.iterator().next();
		
		credencials[0] = cred.getUserName();
		credencials[1] = new String(cred.getPassword());
		
		return credencials;
	}
	
}
