package br.com.experian.gerenciadorperfil.core.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateCompare implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory.getLogger(DateCompare.class);
	private static final long QTD_SEGUNDOS_EM_1_DIA = 86400000;
	private static final String DATE_FORMAT = "dd MM yyyy";
	public static final Date DATE_PLUS_100_YEARS = DateCompare.addYears(new Date(), 100);

	public static boolean before(Date data1, Date data2) {
		Calendar c1 = resetTime(data1);
		Calendar c2 = resetTime(data2);
		return c1.before(c2);
	}

	public static boolean after(Date data1, Date data2) {
		Calendar c1 = resetTime(data1);
		Calendar c2 = resetTime(data2);
		return c1.after(c2);
	}

	public static boolean between(Date data1, Date dataInicio, Date dataFim) {
		Calendar c1 = resetTime(data1);
		Calendar c2 = resetTime(dataInicio);
		Calendar c3 = resetTime(dataFim);
		return ((c1.after(c2) || c1.equals(c2)) && (c1.before(c3) || c1.equals(c3)));
	}

	public static Date addYears(Date date, int years) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }

	private static Calendar resetTime(Date data) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(data);
		c1.set(Calendar.HOUR, 0);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);
		return c1;
	}

	public static Date getToday() {

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.clear(Calendar.AM_PM);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);

		return cal.getTime();
	}

	public static long getDaysBetween(Date dateIni, Date dateFim){
		long agoraInMili = getTimeInMilisFromDateTruncate(dateIni);
		long finalDaCampanhaInMili = getTimeInMilisFromDateTruncate(dateFim);

		long diffInMili = finalDaCampanhaInMili - agoraInMili;

		long diffInDays = diffInMili/QTD_SEGUNDOS_EM_1_DIA;

		return diffInDays;

	}

	private static long getTimeInMilisFromDateTruncate(Date date){

		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

			Date dateResult = dateFormat.parse(dateFormat.format(date));

			long timeInMilisTruncate = dateResult.getTime();

			return timeInMilisTruncate;

		}catch(ParseException e){
			LOGGER.error("Erro ao calcular zero horas da data requisitada. Retornando zero.", e);
		}
		return 0;
	}

}
