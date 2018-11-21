package com.demo.utils;

import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName: QRCodeUtil
 * @Author: zhanghongkai
 * @Date: Create in 2018/11/21 10:49
 * @Version: 1.0
 */
public class QRCodeUtil {
    public static void qrCodeEncode(String encodeData, File deskFile) throws IOException {
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');
        qrcode.setQrcodeEncodeMode('B');
        qrcode.setQrcodeVersion(7);
        byte[] d = encodeData.getBytes("UTF-8");
        BufferedImage bi = new BufferedImage(139, 139, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, 139, 139);
        g.setColor(Color.BLACK);
        if(d.length>0 && d.length<123){
            boolean[][] b = qrcode.calQrcode(d);
            for(int i=0;i<b.length;i++){
                for(int j=0;j<b.length;j++){
                    if(b[j][i]){
                        g.fillRect(j*3+2, i*3+2, 3, 3);
                    }
                }
            }
        }
        g.dispose();
        bi.flush();
        ImageIO.write(bi, "png", deskFile);
    }

    public static String qrCodeDecode(File imageFile){
        String decodeData = null;
        QRCodeDecoder qrCodeDecoder = new QRCodeDecoder();
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            decodeData = new String(qrCodeDecoder.decode(new J2SEImage(bufferedImage)),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decodeData;
    }

    static class J2SEImage implements QRCodeImage {
        BufferedImage bufferedImage;
        public J2SEImage(BufferedImage bufferedImage){
            this.bufferedImage = bufferedImage;
        }
        @Override
        public int getWidth() {
            return bufferedImage.getWidth();
        }

        @Override
        public int getHeight() {
            return bufferedImage.getHeight();
        }

        @Override
        public int getPixel(int i, int i1) {
            return bufferedImage.getRGB(i, i1);
        }
    }
}
