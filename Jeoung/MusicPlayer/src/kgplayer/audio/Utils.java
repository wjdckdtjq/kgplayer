package kgplayer.audio;

import kgplayer.audio.Complex;

public class Utils {

	public static String getMinutesRapp(long microseconds)
	{
		int sec = (int) (microseconds / 1000000);
		int min = sec / 60;
		sec = sec % 60;
		String ms = min + "";
		String ss = sec + "";
		if(ms.length() < 2)
			ms = "0"+ms;
		if(ss.length() < 2)
			ss = "0"+ss;
		return ms+":"+ss;
	}

	public static int getSixteenBitSample(int high, int low) {
		return (high << 8) + (low & 0x00ff);
	}
	
	public static Complex[] fft(Complex[] x){
		int N = x.length;
        if (N == 1) return new Complex[] { x[0] };
        if (N % 2 != 0) { throw new RuntimeException("N is not a power of 2"); }
        Complex[] even = new Complex[N/2];
        for (int k = 0; k < N/2; k++) {
            even[k] = x[2*k];
        }
        Complex[] q = fft(even);
        Complex[] odd  = even;  // reuse the array
        for (int k = 0; k < N/2; k++) {
            odd[k] = x[2*k + 1];
        }
        Complex[] r = fft(odd);
        Complex[] y = new Complex[N];
        for (int k = 0; k < N/2; k++) {
            double kth = -2 * k * Math.PI / N;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            y[k]       = q[k].plus(wk.times(r[k]));
            y[k + N/2] = q[k].minus(wk.times(r[k]));
        }
        return y;
	}
	
	public static int log(int x, int base)
	{
	    return (int) (Math.log(x) / Math.log(base));
	}
}