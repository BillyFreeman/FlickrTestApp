package victor.tech.flickrtestapp.util;


import java.util.List;

import victor.tech.flickrtestapp.commons.Rectangle;

public class RectUtil {

    public static <R extends Rectangle> R findBestFitRect(int width, int height, List<R> rects) {
        ensureValidList(rects);
        float targetAspectRatio = (float) height / width;
        R rect = rects.get(0);
        float aspectRatio = (float) rect.height() / rect.width();
        if (aspectRatio <= targetAspectRatio) {
            return getBestFitByWidth(width, rects);
        } else {
            return getBestFitByHeight(height, rects);
        }
    }

    public static <R extends Rectangle> R getBestFitByWidth(int width, List<R> rects) {
        R bestRect = rects.get(0);
        for (int i = 1; i < rects.size(); i++) {
            R rect = rects.get(i);
            if (rect.width() > bestRect.width() && rect.width() <= width) {
                bestRect = rect;
            }
        }
        return bestRect;
    }

    public static <R extends Rectangle> R getBestFitByHeight(int height, List<R> rects) {
        R bestRect = rects.get(0);
        for (int i = 1; i < rects.size(); i++) {
            R rect = rects.get(i);
            if (rect.height() > bestRect.width() && rect.height() <= height) {
                bestRect = rect;
            }
        }
        return bestRect;
    }

    private static void ensureValidList(List list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is null or empty");
        }
    }
}
