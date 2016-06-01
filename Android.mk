# Copyright 2011 The Android Open Source Project

LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-java-files-under, src)
LOCAL_STATIC_JAVA_LIBRARIES := android-support-v4

LOCAL_PACKAGE_NAME := TestCellBroadcast
LOCAL_CERTIFICATE := platform
LOCAL_PRIVILEGED_MODULE := true

include $(BUILD_PACKAGE)

#include $(CLEAR_VARS)  
#
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES :=android-support-v4:libs/android-support-v4.jar
#
#include $(BUILD_MULTI_PREBUILT)  
