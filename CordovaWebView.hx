package;

#if cpp
import cpp.Lib;
#elseif neko
import neko.Lib;
#end

#if (android && openfl)
import openfl.utils.JNI;
#end


class CordovaWebView {
	
	
	public static function open(json:String):Void {
		#if flash
			return ;
		#end
		#if (android && openfl)
		
		 cordova_webview_open_jni(json);
		 
		
		 
		
		#end
		
		#if ios
		
		  cordova_webview_sample_method(0);
		
		#end
		
	}
	
	#if ios
	private static var cordova_webview_sample_method = Lib.load ("cordova_webview", "cordova_webview_sample_method", 1);
	#end
	#if (android && openfl)
	private static var cordova_webview_open_jni = JNI.createStaticMethod ("org.haxe.h5.CordovaExtension", "open", "(Ljava/lang/String;)V");
	#end
	
	
}