#include <jni.h>

JNIEXPORT jint JNICALL
Java_com_gohon_material_jnisample_Library_getNum(JNIEnv *env, jobject instance) {

    // TODO

    return 89;
}

JNIEXPORT jstring JNICALL
Java_com_gohon_material_jnisample_Library_getString(JNIEnv *env, jobject instance) {

    // TODO

   jstring *jstr =(*env)->NewStringUTF(env, "users");


    return getTest(env);
}

jstring getTest(JNIEnv *env){
    return (*env)->NewStringUTF(env,"user1");
}