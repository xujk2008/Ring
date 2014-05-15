package com.kitexu.common;

public class LocationCaculator {
	
	private final static double EARTH_RADIUS = 6378137.0;
	
	public static double getDistance(double lng_a, double lat_a, double lng_b, double lat_b) {
		double radLat1 = (lat_a * Math.PI / 180.0);
		double radLat2 = (lat_b * Math.PI / 180.0);
		double a = radLat1 - radLat2;
		double b = (lng_a - lng_b) * Math.PI / 180.0;
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
		+ Math.cos(radLat1) * Math.cos(radLat2)
		* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
		}
	
	public static double getAzimuth(double lng_a, double lat_a, double lng_b, double lat_b) {
		double d = 0;
		lat_a = lat_a * Math.PI / 180;
		lng_a = lng_a * Math.PI / 180;
		lat_b = lat_b * Math.PI / 180;
		lng_b = lng_b * Math.PI / 180;

		d = Math.sin(lat_a) * Math.sin(lat_b) + Math.cos(lat_a)
				* Math.cos(lat_b) * Math.cos(lng_b - lng_a);
		d = Math.sqrt(1 - d * d);
		d = Math.cos(lat_b) * Math.sin(lng_b - lng_a) / d;
		d = Math.asin(d) * 180 / Math.PI;

		return d;
	}
	
	public static double computeAzimuth(double lon1, double lat1, double lon2, double lat2) 
	{

		double result = 0.0;

		int ilat1 = (int) (0.50 + lat1 * 360000.0);
		int ilat2 = (int) (0.50 + lat2 * 360000.0);
		int ilon1 = (int) (0.50 + lon1 * 360000.0);
		int ilon2 = (int) (0.50 + lon2 * 360000.0);

		lat1 = Math.toRadians(lat1);
		lon1 = Math.toRadians(lon1);
		lat2 = Math.toRadians(lat2);
		lon2 = Math.toRadians(lon2);

		if ((ilat1 == ilat2) && (ilon1 == ilon2)) {
			return result;
		} else if (ilon1 == ilon2) {
			if (ilat1 > ilat2)
				result = 180.0;
		} else {
			double c = Math
					.acos(Math.sin(lat2) * Math.sin(lat1) + Math.cos(lat2)
							* Math.cos(lat1) * Math.cos((lon2 - lon1)));
			double A = Math.asin(Math.cos(lat2) * Math.sin((lon2 - lon1))
					/ Math.sin(c));
			result = Math.toDegrees(A);
			if ((ilat2 > ilat1) && (ilon2 > ilon1)) {
			} else if ((ilat2 < ilat1) && (ilon2 < ilon1)) {
				result = 180.0 - result;
			} else if ((ilat2 < ilat1) && (ilon2 > ilon1)) {
				result = 180.0 - result;
			} else if ((ilat2 > ilat1) && (ilon2 < ilon1)) {
				result += 360.0;
			}
		}
		return result;
	}

}
