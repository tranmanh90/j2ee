package com.book.store.uf;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.StringCharacterIterator;

public class StringUtil {

	public StringUtil() {
	}

	public static boolean isNull(String value) {
		return value == null || "".equals(value);
	}

	public static boolean isNotNull(String value) {
		return !isNull(value);
	}

	public static String UTF8URLEncode(String str) {
		if (str == null)
			return null;
		String strTmp = str.trim();
		try {
			strTmp = URLEncoder.encode(strTmp, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println((new StringBuilder("-- UTF8URLEncode Error [")).append(str).append("] [")
					.append(e.getMessage()).append("]").toString());
		}
		return strTmp;
	}

	public static String UTF8URLDecode(String str) {
		if (str == null)
			return null;
		String strTmp = str.trim();
		try {
			strTmp = URLDecoder.decode(strTmp, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println((new StringBuilder("-- UTF8URLDecode Error [")).append(str).append("] [")
					.append(e.getMessage()).append("]").toString());
		}
		return strTmp;
	}

	public static String char2latin(String str, String charset) {
		if (str == null)
			return null;
		String strTmp = str.trim();
		try {
			if (charset.equalsIgnoreCase("EUC-KR"))
				strTmp = new String(strTmp.getBytes("8859_1"));
			else
				strTmp = new String(strTmp.getBytes("8859_1"), charset);
		} catch (UnsupportedEncodingException e) {
			System.out.println((new StringBuilder("-- char2latin Error [")).append(str).append("] [").append(charset)
					.append("] [").append(e.getMessage()).append("]").toString());
		}
		return strTmp;
	}

	public static String uni2latin(String str) {
		return char2latin(str, "UTF-8");
	}

	public static String DBEncode(String str) {
		if (str == null) {
			return null;
		} else {
			String strTmp = str.trim();
			return strTmp;
		}
	}

	public static String DBDecode(String str) {
		if (str == null) {
			return null;
		} else {
			String strTmp = str.trim();
			return strTmp;
		}
	}

	public static String getDownloadFileName(String str) throws UnsupportedEncodingException {
		return getDownloadFileName(str, null);
	}

	public static String getDownloadFileName(String str, String agent) throws UnsupportedEncodingException {
		if (isNull(str))
			return "unknown";
		else
			return getLatinEncFileName(str, agent);
	}

	public static String getLatinEncFileName(String str) throws UnsupportedEncodingException {
		return getLatinEncFileName(str, null);
	}

	public static String getLatinEncFileName(String str, String agent) throws UnsupportedEncodingException {
		if (str == null)
			return "";
		String fileName = str.replaceAll("\\\\", "");
		fileName = fileName.replaceAll("[\t\n\r]", " ");
		fileName = fileName.replaceAll("[/:*?\"<>|]", "_");
		if (agent != null && (agent.toUpperCase().indexOf("FIREFOX") > 0 || agent.toUpperCase().indexOf("NETSCAPE") > 0
				|| agent.toUpperCase().indexOf("WEBKIT") > 0))
			fileName = new String(fileName.getBytes("UTF-8"), "8859_1");
		else if (agent.toUpperCase().indexOf("MSIE 6") > 0)
			fileName = getURLEncFileName(fileName, 170);
		else if (agent.toUpperCase().indexOf("MSIE 8") > 0)
			fileName = getURLEncFileName(fileName, 1000);
		else
			fileName = getURLEncFileName(fileName, 170);
		return fileName;
	}

	public static String getURLEncFileName(String str) throws UnsupportedEncodingException {
		return getURLEncFileName(str, 570);
	}

	public static String getURLEncFileName(String str, int len) throws UnsupportedEncodingException {
		String strExt = "";
		String strName = "";
		int start = 0;
		if (str == null)
			return "";
		String fileName = str.replaceAll("\\\\", "");
		fileName = fileName.replaceAll("[\t\n\r]", " ");
		fileName = fileName.replaceAll("[/:*?\"<>|]", "_");
		fileName = fileName.replaceAll(" ", "_");
		fileName = UTF8URLEncode(fileName);
		if (fileName.length() < len)
			return fileName;
		start = str.lastIndexOf('.');
		if (start > 0) {
			strExt = str.substring(start);
			strName = str.substring(0, start);
		} else {
			strName = str;
		}
		for (; fileName.length() >= len; fileName = UTF8URLEncode(fileName)) {
			strName = strName.substring(0, strName.length() - 2);
			fileName = (new StringBuilder(String.valueOf(strName))).append("~").append(strExt).toString();
			fileName = fileName.replaceAll("\\\\", "");
			fileName = fileName.replaceAll("[\t\n\r]", " ");
			fileName = fileName.replaceAll("[/:*?\"<>|]", "_");
			fileName = fileName.replaceAll(" ", "_");
		}

		return fileName;
	}

	public static String EscapeMailParam(String str) {
		if (str != null)
			str = str.replaceAll("'", "\\\\'");
		return EscapeHTMLTag(str);
	}

	public static String EscapeQuot(String aTagFragment) {
		StringBuffer result = new StringBuffer();
		StringCharacterIterator iterator = new StringCharacterIterator(aTagFragment);
		for (char character = iterator.current(); character != '\uFFFF'; character = iterator.next())
			if (character == '"')
				result.append("\\\"");
			else if (character == '\'')
				result.append("\\'");
			else
				result.append(character);

		return result.toString();
	}

	public static String EscapeSqlChar(String aTagFragment) {
		StringBuffer result = new StringBuffer();
		StringCharacterIterator iterator = new StringCharacterIterator(aTagFragment);
		for (char character = iterator.current(); character != '\uFFFF'; character = iterator.next())
			if (character == '"')
				result.append("\\\"");
			else if (character == '\'')
				result.append("\\'");
			else if (character == '%')
				result.append("\\\\%");
			else if (character == '_')
				result.append("\\_");
			else
				result.append(character);

		return result.toString();
	}

	public static String EscapeHTMLTag(String aTagFragment) {
		StringBuffer result = new StringBuffer();
		if (aTagFragment != null) {
			StringCharacterIterator iterator = new StringCharacterIterator(aTagFragment);
			for (char character = iterator.current(); character != '\uFFFF'; character = iterator.next())
				switch (character) {
				case 60: // '<'
					result.append("&lt;");
					break;

				case 62: // '>'
					result.append("&gt;");
					break;

				case 38: // '&'
					result.append("&amp;");
					break;

				case 34: // '"'
					result.append("&quot;");
					break;

				case 39: // '\''
					result.append("&#39;");
					break;

				case 92: // '\\'
					result.append("&#092;");
					break;

				case 123: // '{'
					result.append("&#123;");
					break;

				case 125: // '}'
					result.append("&#125;");
					break;

				case 91: // '['
					result.append("&#91;");
					break;

				case 93: // ']'
					result.append("&#93;");
					break;

				case 58: // ':'
					result.append("&#58;");
					break;

				default:
					result.append(character);
					break;
				}

		}
		return getCRLFEscape(result.toString());
	}

	public static String EscapeBackSlash(String str) {
		if (isNull(str))
			return "";
		else
			return str.replaceAll("\\\\", "\\\\\\\\");
	}

	public static boolean eq(String s1, String s2) {
		if (isNull(s1) || isNull(s2))
			return false;
		else
			return s1.equals(s2);
	}

	public static boolean eqIgn(String s1, String s2) {
		if (isNull(s1) || isNull(s2))
			return false;
		else
			return s1.equalsIgnoreCase(s2);
	}

	public static boolean inc(String s1, String s2) {
		if (isNull(s1) || isNull(s2))
			return false;
		return s1.indexOf(s2) >= 0;
	}

	public static boolean isEmpty(String txt) {
		if (txt == null)
			return true;
		return "".equals(txt.trim());
	}

	public static boolean isNotEmpty(String txt) {
		return !isEmpty(txt);
	}

	public static long[] getStringsToLongs(String longStrs[]) {
		long longValues[] = (long[]) null;
		if (longStrs != null) {
			int size = longStrs.length;
			longValues = new long[size];
			for (int i = 0; i < size; i++)
				longValues[i] = Long.parseLong(longStrs[i]);

		}
		return longValues;
	}

	public static String getLongsToString(long longs[]) {
		StringBuffer sb = new StringBuffer();
		if (longs != null) {
			int size = longs.length;
			for (int i = 0; i < size; i++) {
				if (i > 0)
					sb.append(",");
				sb.append(longs[i]);
			}

		}
		return sb.toString();
	}

	public static int[] getStringsToInteger(String intStrs[]) {
		int intValues[] = (int[]) null;
		if (intStrs != null) {
			int size = intStrs.length;
			intValues = new int[size];
			for (int i = 0; i < size; i++)
				intValues[i] = Integer.parseInt(intStrs[i]);

		}
		return intValues;
	}

	public static String getCRLFEscape(String str) {
		StringBuffer result = new StringBuffer();
		if (str != null) {
			StringCharacterIterator iterator = new StringCharacterIterator(str);
			for (char character = iterator.current(); character != '\uFFFF'; character = iterator.next())
				if (Character.getType(character) != 15)
					switch (character) {
					case 10: // '\n'
						result.append("\n");
						break;

					case 9: // '\t'
						result.append(" ");
						break;

					case 13: // '\r'
						result.append(" ");
						break;

					case 11: // '\013'
					case 12: // '\f'
					default:
						result.append(character);
						break;
					}
				else if (character == '\n')
					result.append("\n");
				else
					result.append(" ");

		}
		return result.toString();
	}

	public static String replace(String src, String oldstr, String newstr) {
		if (src == null)
			return null;
		StringBuffer dest = new StringBuffer("");
		int len = oldstr.length();
		int srclen = src.length();
		int pos = 0;
		int oldpos;
		for (oldpos = 0; (pos = src.indexOf(oldstr, oldpos)) >= 0; oldpos = pos + len) {
			dest.append(src.substring(oldpos, pos));
			dest.append(newstr);
		}

		if (oldpos < srclen)
			dest.append(src.substring(oldpos, srclen));
		return dest.toString();
	}

	public static int javaToHtml(char ch[], int start, int length, char out[]) {
		boolean specialChars[] = new boolean[128];
		for (int i = 0; i < 128; i++)
			specialChars[i] = false;

		specialChars[60] = true;
		specialChars[62] = true;
		specialChars[38] = true;
		specialChars[39] = true;
		specialChars[34] = true;
		int o = 0;
		for (int i = start; i < start + length; i++)
			if (ch[i] <= '\177' && !specialChars[ch[i]]) {
				out[o] = ch[i];
				o++;
			} else if (ch[i] == '<') {
				"&lt;".getChars(0, 4, out, o);
				o += 4;
			} else if (ch[i] == '>') {
				"&gt;".getChars(0, 4, out, o);
				o += 4;
			} else if (ch[i] == '&') {
				"&amp;".getChars(0, 5, out, o);
				o += 5;
			} else if (ch[i] == '"') {
				"&#34;".getChars(0, 5, out, o);
				o += 5;
			} else if (ch[i] == '\'') {
				"&#39;".getChars(0, 5, out, o);
				o += 5;
			} else {
				String dec = (new StringBuilder("&#")).append(Integer.toString(ch[i])).append(';').toString();
				dec.getChars(0, dec.length(), out, o);
				o += dec.length();
			}

		return o;
	}

	public static String javaToHtml(String source) {
		char dest[] = new char[source.length() * 8];
		int newlen = javaToHtml(source.toCharArray(), 0, source.length(), dest);
		return new String(dest, 0, newlen);
	}

	public static String join(String values[], String delimiter) {
		if (values == null)
			return null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < values.length; i++)
			sb.append(values[i]).append(delimiter);

		if (values.length > 0)
			return sb.substring(0, sb.lastIndexOf(delimiter));
		else
			return sb.toString();
	}

	public static String camelize(String str) {
		String camelized = "";
		String parts[] = str.toLowerCase().split("_");
		int len = parts.length;
		if (len == 0)
			return "";
		camelized = parts[0];
		for (int i = 1; i < len; i++)
			camelized = (new StringBuilder(String.valueOf(camelized))).append(parts[i].substring(0, 1).toUpperCase())
					.append(parts[i].substring(1)).toString();

		return camelized;
	}

	public static String[] camelize(String strs[]) {
		String results[] = new String[strs.length];
		int i = 0;
		String as[];
		int k = (as = strs).length;
		for (int j = 0; j < k; j++) {
			String each = as[j];
			results[i] = camelize(each);
			i++;
		}

		return results;
	}

	public static String underscore(String str) {
		if (str == null || str.length() == 0)
			return str;
		StringBuffer sb = new StringBuffer();
		int len = str.length();
		int index = 0;
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			if (Character.isUpperCase(ch)) {
				sb.append(str.substring(index, i)).append("_");
				index = i;
			}
		}

		if (index < len)
			sb.append(str.substring(index));
		return sb.toString().toLowerCase();
	}

	public static String null2Str(String value) {
		return value != null && !value.equalsIgnoreCase("null") ? value : "";
	}

	public static String capitalize(String str) {
		if (str == null || str.length() == 0)
			return str;
		else
			return (new StringBuilder(String.valueOf(Character.toUpperCase(str.charAt(0))))).append(str.substring(1))
					.toString();
	}

	public static String decapitalize(String str) {
		if (str == null || str.length() == 0)
			return str;
		else
			return (new StringBuilder(String.valueOf(Character.toLowerCase(str.charAt(0))))).append(str.substring(1))
					.toString();
	}

	public static String reverseString(String s) {
		return (new StringBuffer(s)).reverse().toString();
	}

	public static String masking(String mask, String value) {
		if (isEmpty(value))
			value = "";
		if (isEmpty(mask))
			mask = "*";
		return masking(mask, value, 0, value.length() - 1);
	}

	public static String masking(String mask, String value, int startPos, int endPos) {
		if (isEmpty(value))
			return "";
		if (isEmpty(mask))
			mask = "*";
		if (startPos > endPos) {
			int tmp = startPos;
			startPos = endPos;
			endPos = tmp;
		}
		int index = 0;
		StringBuilder maskedNumber = new StringBuilder();
		for (int i = 0; i <= endPos; i++)
			if (i < startPos)
				maskedNumber.append(value.charAt(i));
			else
				maskedNumber.append(mask.charAt(index));

		return maskedNumber.toString();
	}
}
