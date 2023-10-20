package GraphicsApp.demo;

public class ColorConverter {

    public float[] rbgToCmyk(int red, int green, int blue) {
        float r = red / 255.0f;
        float g = green / 255.0f;
        float b = blue / 255.0f;

        float k = 1 - Math.max(Math.max(r, g), b);
        float c = (1 - r - k) / (1 - k);
        float m = (1 - g - k) / (1 - k);
        float y = (1 - b - k) / (1 - k);

        return new float[]{c, m, y, k};
    }

    public int[] cmykToRgb(float c, float m, float y, float k) {
        int red = (int) (255 * (1 - c) * (1 - k));
        int green = (int) (255 * (1 - m) * (1 - k));
        int blue = (int) (255 * (1 - y) * (1 - k));

        return new int[]{red, green, blue};
    }

    public float[] rgbToHls(int red, int green, int blue) {
        float r = red / 255.0f;
        float g = green / 255.0f;
        float b = blue / 255.0f;

        float max = Math.max(Math.max(r, g), b);
        float min = Math.min(Math.min(r, g), b);
        float l = (max + min) / 2;
        float h, s;

        if (max == min) {
            h = s = 0; // gray
        } else {
            float d = max - min;
            s = l > 0.5 ? d / (2 - max - min) : d / (max + min);

            if (max == r) {
                h = (g - b) / d + (g < b ? 6 : 0);
            } else if (max == g) {
                h = (b - r) / d + 2;
            } else {
                h = (r - g) / d + 4;
            }

            h /= 6;
        }

        return new float[]{h * 360, s * 100, l * 100};
    }

    public static int[] hlsToRgb(float h, float l, float s) {
        float c = (1 - Math.abs(2 * l - 1)) * s;
        float x = c * (1 - Math.abs((h / 60) % 2 - 1));
        float m = l - c / 2;
        int red, green, blue;

        if (h >= 0 && h < 60) {
            red = (int) (255 * (c + m));
            green = (int) (255 * (x + m));
            blue = (int) (255 * m);
        } else if (h >= 60 && h < 120) {
            red = (int) (255 * (x + m));
            green = (int) (255 * (c + m));
            blue = (int) (255 * m);
        } else if (h >= 120 && h < 180) {
            red = (int) (255 * m);
            green = (int) (255 * (c + m));
            blue = (int) (255 * (x + m));
        } else if (h >= 180 && h < 240) {
            red = (int) (255 * m);
            green = (int) (255 * (x + m));
            blue = (int) (255 * (c + m));
        } else if (h >= 240 && h < 300) {
            red = (int) (255 * (x + m));
            green = (int) (255 * m);
            blue = (int) (255 * (c + m));
        } else {
            red = (int) (255 * (c + m));
            green = (int) (255 * m);
            blue = (int) (255 * (x + m));
        }

        return new int[]{red, green, blue};
    }




}
