package com.niki.dicodingjetpackpro;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void toSimpleString() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("02/28/2018");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals("Wed, 28 Feb 2018", Utils.toSimpleString(date));
    }
}