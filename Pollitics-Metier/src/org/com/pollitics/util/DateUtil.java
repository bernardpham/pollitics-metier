package org.com.pollitics.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.com.pollitics.exception.TechnicalException;

public class DateUtil {

	private static final String DATE_FORMAT_EU_DD_MM_YYYY = "dd/MM/yyyy";

	public static Date getDateFromString(String dateToFormat) throws TechnicalException {

		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_EU_DD_MM_YYYY);
		try {
			Date date = formatter.parse(dateToFormat);
			return date;
		} catch (ParseException e) {
			throw new TechnicalException(e.getMessage());
		}

	}

}
