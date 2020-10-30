package com.hms.app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;

import org.springframework.stereotype.Component;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;
@Component
public class JsonUtils {
	private Gson gson=new Gson();
	
	public Object parseJson(String path, Object object, Class clazz) throws IOException {

		InputStream is = this.getClass().getResourceAsStream(path);

		try (Reader reader = new InputStreamReader(is)) {
			String text = CharStreams.toString(reader);
			object = gson.fromJson(text, clazz);

		}
		return object;
	}

	public Object parseJsonList(String path, Object object, Type type) throws IOException {
		InputStream is = this.getClass().getResourceAsStream(path);

		try (Reader reader = new InputStreamReader(is)) {
			String text = CharStreams.toString(reader);
			object = gson.fromJson(text, type);

		}
		return object;
	}

}
