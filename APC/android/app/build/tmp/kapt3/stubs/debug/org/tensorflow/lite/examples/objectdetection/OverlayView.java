package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 H2\u00020\u0001:\u0001HB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020:H\u0002J$\u0010?\u001a\u00020:2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020+0A2\u0006\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u0017J\u001e\u0010D\u001a\u00020:2\u0006\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\b\u001f\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\u001a\u0010 \u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR\u001a\u0010#\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010&\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0019\"\u0004\b(\u0010\u001bR\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001bR\u000e\u0010/\u001a\u000200X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00101\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR\u000e\u00104\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u001707X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/OverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Passengers_In", "Landroid/graphics/Rect;", "getPassengers_In", "()Landroid/graphics/Rect;", "setPassengers_In", "(Landroid/graphics/Rect;)V", "Passengers_net", "getPassengers_net", "setPassengers_net", "Passengers_out", "getPassengers_out", "setPassengers_out", "bounds", "boxPaint", "Landroid/graphics/Paint;", "delay", "", "getDelay", "()I", "setDelay", "(I)V", "door_status", "getDoor_status", "setDoor_status", "door_status$1", "leftBoundary", "getLeftBoundary", "setLeftBoundary", "middleBoundary", "getMiddleBoundary", "setMiddleBoundary", "net", "getNet", "setNet", "results", "", "Lorg/tensorflow/lite/task/vision/detector/Detection;", "rightBoundary", "getRightBoundary", "setRightBoundary", "scaleFactor", "", "space_among_score_texts", "getSpace_among_score_texts", "setSpace_among_score_texts", "textBackgroundPaint", "textPaint", "tracked_objects", "Ljava/util/HashMap;", "", "clear", "", "draw", "canvas", "Landroid/graphics/Canvas;", "initPaints", "setResults", "detectionResults", "", "imageHeight", "imageWidth", "update_passenger_count", "tracking_id", "object_left_corner", "object_right_corner", "Companion", "app_debug"})
public final class OverlayView extends android.view.View {
    private java.util.List<? extends org.tensorflow.lite.task.vision.detector.Detection> results;
    private android.graphics.Paint boxPaint;
    private android.graphics.Paint textBackgroundPaint;
    private android.graphics.Paint textPaint;
    private float scaleFactor = 1.0F;
    private android.graphics.Rect bounds;
    private java.util.HashMap<java.lang.String, java.lang.Integer> tracked_objects;
    private int leftBoundary;
    private int rightBoundary;
    private int middleBoundary;
    private int delay = 700;
    private int space_among_score_texts = 360;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Rect Passengers_In;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Rect door_status$1;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Rect Passengers_net;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Rect Passengers_out;
    private int net;
    @org.jetbrains.annotations.NotNull()
    public static final org.tensorflow.lite.examples.objectdetection.OverlayView.Companion Companion = null;
    private static final int BOUNDING_RECT_TEXT_PADDING = 8;
    private static int ImageWidth = 320;
    private static int ImageHeight = 320;
    private static boolean door_status = false;
    
    public OverlayView(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public final int getLeftBoundary() {
        return 0;
    }
    
    public final void setLeftBoundary(int p0) {
    }
    
    public final int getRightBoundary() {
        return 0;
    }
    
    public final void setRightBoundary(int p0) {
    }
    
    public final int getMiddleBoundary() {
        return 0;
    }
    
    public final void setMiddleBoundary(int p0) {
    }
    
    public final int getDelay() {
        return 0;
    }
    
    public final void setDelay(int p0) {
    }
    
    public final int getSpace_among_score_texts() {
        return 0;
    }
    
    public final void setSpace_among_score_texts(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Rect getPassengers_In() {
        return null;
    }
    
    public final void setPassengers_In(@org.jetbrains.annotations.NotNull()
    android.graphics.Rect p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Rect getDoor_status() {
        return null;
    }
    
    public final void setDoor_status(@org.jetbrains.annotations.NotNull()
    android.graphics.Rect p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Rect getPassengers_net() {
        return null;
    }
    
    public final void setPassengers_net(@org.jetbrains.annotations.NotNull()
    android.graphics.Rect p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Rect getPassengers_out() {
        return null;
    }
    
    public final void setPassengers_out(@org.jetbrains.annotations.NotNull()
    android.graphics.Rect p0) {
    }
    
    public final int getNet() {
        return 0;
    }
    
    public final void setNet(int p0) {
    }
    
    public final void clear() {
    }
    
    private final void initPaints() {
    }
    
    @java.lang.Override()
    public void draw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public final void setResults(@org.jetbrains.annotations.NotNull()
    java.util.List<org.tensorflow.lite.task.vision.detector.Detection> detectionResults, int imageHeight, int imageWidth) {
    }
    
    public final void update_passenger_count(@org.jetbrains.annotations.NotNull()
    java.lang.String tracking_id, int object_left_corner, int object_right_corner) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/OverlayView$Companion;", "", "()V", "BOUNDING_RECT_TEXT_PADDING", "", "ImageHeight", "getImageHeight", "()I", "setImageHeight", "(I)V", "ImageWidth", "getImageWidth", "setImageWidth", "door_status", "", "getDoor_status", "()Z", "setDoor_status", "(Z)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final int getImageWidth() {
            return 0;
        }
        
        public final void setImageWidth(int p0) {
        }
        
        public final int getImageHeight() {
            return 0;
        }
        
        public final void setImageHeight(int p0) {
        }
        
        public final boolean getDoor_status() {
            return false;
        }
        
        public final void setDoor_status(boolean p0) {
        }
    }
}