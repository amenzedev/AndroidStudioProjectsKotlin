package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001AB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000203H\u0002J$\u00108\u001a\u0002032\f\u00109\u001a\b\u0012\u0004\u0012\u00020$0:2\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0017J\u001e\u0010=\u001a\u0002032\u0006\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b\'\u0010\u001bR\u000e\u0010(\u001a\u00020)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u000e\u0010-\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001700X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/OverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Passengers_In", "Landroid/graphics/Rect;", "getPassengers_In", "()Landroid/graphics/Rect;", "setPassengers_In", "(Landroid/graphics/Rect;)V", "Passengers_net", "getPassengers_net", "setPassengers_net", "Passengers_out", "getPassengers_out", "setPassengers_out", "bounds", "boxPaint", "Landroid/graphics/Paint;", "leftBoundary", "", "getLeftBoundary", "()I", "setLeftBoundary", "(I)V", "middleBoundary", "getMiddleBoundary", "setMiddleBoundary", "net", "getNet", "setNet", "results", "", "Lorg/tensorflow/lite/task/vision/detector/Detection;", "rightBoundary", "getRightBoundary", "setRightBoundary", "scaleFactor", "", "space_among_score_texts", "getSpace_among_score_texts", "setSpace_among_score_texts", "textBackgroundPaint", "textPaint", "tracked_objects", "Ljava/util/HashMap;", "", "clear", "", "draw", "canvas", "Landroid/graphics/Canvas;", "initPaints", "setResults", "detectionResults", "", "imageHeight", "imageWidth", "update_passenger_count", "tracking_id", "object_left_corner", "object_right_corner", "Companion", "app_debug"})
public final class OverlayView extends android.view.View {
    private java.util.List<? extends org.tensorflow.lite.task.vision.detector.Detection> results;
    private android.graphics.Paint boxPaint;
    private android.graphics.Paint textBackgroundPaint;
    private android.graphics.Paint textPaint;
    private float scaleFactor = 1.0F;
    private android.graphics.Rect bounds;
    private java.util.HashMap<java.lang.String, java.lang.Integer> tracked_objects;
    private int space_among_score_texts = 360;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Rect Passengers_In;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Rect Passengers_net;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Rect Passengers_out;
    private int net;
    private int leftBoundary;
    private int rightBoundary;
    private int middleBoundary;
    @org.jetbrains.annotations.NotNull()
    public static final org.tensorflow.lite.examples.objectdetection.OverlayView.Companion Companion = null;
    private static final int BOUNDING_RECT_TEXT_PADDING = 8;
    private static int ImageWidth = 1080;
    private static int ImageHeight = 2000;
    
    public OverlayView(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t\u00a8\u0006\r"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/OverlayView$Companion;", "", "()V", "BOUNDING_RECT_TEXT_PADDING", "", "ImageHeight", "getImageHeight", "()I", "setImageHeight", "(I)V", "ImageWidth", "getImageWidth", "setImageWidth", "app_debug"})
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
    }
}