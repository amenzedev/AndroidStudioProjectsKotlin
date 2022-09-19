package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

/**
 * Main entry point into our app. This app follows the single-activity pattern, and all
 * functionality is implemented in the form of fragments.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "activityMainBinding", "Lorg/tensorflow/lite/examples/objectdetection/databinding/ActivityMainBinding;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private org.tensorflow.lite.examples.objectdetection.databinding.ActivityMainBinding activityMainBinding;
    @org.jetbrains.annotations.NotNull()
    public static final org.tensorflow.lite.examples.objectdetection.MainActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static java.util.HashMap<java.lang.String, int[]> incoming_passengers;
    @org.jetbrains.annotations.NotNull()
    private static java.util.HashMap<java.lang.String, int[]> outgoing_passengers;
    private static int passengers_in_count = 0;
    private static int passengers_out_count = 0;
    public static org.tensorflow.lite.examples.objectdetection.CentroidTracking tracking;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/MainActivity$Companion;", "", "()V", "incoming_passengers", "Ljava/util/HashMap;", "", "", "getIncoming_passengers", "()Ljava/util/HashMap;", "setIncoming_passengers", "(Ljava/util/HashMap;)V", "outgoing_passengers", "getOutgoing_passengers", "setOutgoing_passengers", "passengers_in_count", "", "getPassengers_in_count", "()I", "setPassengers_in_count", "(I)V", "passengers_out_count", "getPassengers_out_count", "setPassengers_out_count", "tracking", "Lorg/tensorflow/lite/examples/objectdetection/CentroidTracking;", "getTracking", "()Lorg/tensorflow/lite/examples/objectdetection/CentroidTracking;", "setTracking", "(Lorg/tensorflow/lite/examples/objectdetection/CentroidTracking;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.HashMap<java.lang.String, int[]> getIncoming_passengers() {
            return null;
        }
        
        public final void setIncoming_passengers(@org.jetbrains.annotations.NotNull()
        java.util.HashMap<java.lang.String, int[]> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.HashMap<java.lang.String, int[]> getOutgoing_passengers() {
            return null;
        }
        
        public final void setOutgoing_passengers(@org.jetbrains.annotations.NotNull()
        java.util.HashMap<java.lang.String, int[]> p0) {
        }
        
        public final int getPassengers_in_count() {
            return 0;
        }
        
        public final void setPassengers_in_count(int p0) {
        }
        
        public final int getPassengers_out_count() {
            return 0;
        }
        
        public final void setPassengers_out_count(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.tensorflow.lite.examples.objectdetection.CentroidTracking getTracking() {
            return null;
        }
        
        public final void setTracking(@org.jetbrains.annotations.NotNull()
        org.tensorflow.lite.examples.objectdetection.CentroidTracking p0) {
        }
    }
}