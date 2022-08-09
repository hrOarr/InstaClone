package com.astrodust.instaclone.dto;

public class ImageDefinition {
    public static final String TIFF = "TIFF";
    public static final String JPEG = "JPEG";
    public static final String PNG	= "PNG";


    public static final String TIFF_MIME = "image/tiff";
    public static final String XTIFF_MIME = "image/x-tiff";
    public static final String JPEG_MIME = "image/jpeg";
    public static final String PJPEG_MIME = "image/pjpeg";
    public static final String PNG_MIME  = "image/png";

    public static String getImageExt(String imgType){
        if(imgType==null)return null;
        if (imgType.equalsIgnoreCase(TIFF_MIME)) return TIFF;
        else if (imgType.equalsIgnoreCase(XTIFF_MIME)) return TIFF;
        else if (imgType.equalsIgnoreCase(JPEG_MIME)) return JPEG;
        else if (imgType.equalsIgnoreCase(PJPEG_MIME)) return JPEG;
        else if (imgType.equalsIgnoreCase(PNG_MIME)) return PNG;
        else return null;
    }
}
