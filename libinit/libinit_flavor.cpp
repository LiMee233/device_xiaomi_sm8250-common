/*
 * Copyright (C) 2021 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#include <android-base/properties.h>
#include <libinit_utils.h>

#include <libinit_flavor.h>

using android::base::GetProperty;

#define FLAVOR_PROP "ro.build.flavor"
#define TARGET_DEVICE_PROP "ro.build.product"
#define TARGET_BUILD_TYPE_PROP "ro.build.type"

void set_flavor_prop(bool setCustomFlavor, const std::string &customFlavor) {
    if(setCustomFlavor) {
        property_override(FLAVOR_PROP, customFlavor);
    }
    else {
        std::string targetBuildType = GetProperty(TARGET_BUILD_TYPE_PROP, "");
        std::string targetDevice = GetProperty(TARGET_DEVICE_PROP, "");
        property_override(FLAVOR_PROP, targetDevice + "-" + targetBuildType);
    }
}
