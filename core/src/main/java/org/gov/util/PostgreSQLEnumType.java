package org.gov.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

/**
 * Usa o tipo proprietário Enum do PostgreSQL
 */
public class PostgreSQLEnumType extends org.hibernate.type.EnumType<Enum<?>> {

	private static final long serialVersionUID = 1;

	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.OTHER);
		} else {
			st.setObject(index, value.toString(), Types.OTHER);
		}
	}
}