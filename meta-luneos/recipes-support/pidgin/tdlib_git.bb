SUMMARY = "Cross-platform library for building Telegram clients"
SECTION = "webos/services"
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE_1_0.txt;md5=e4224ccaecb14d942c71d31bef20d78c"

DEPENDS = "json-glib zlib tdlib-native"
DEPENDS:class-native = "json-glib zlib gperf"

BBCLASSEXTEND = "native"

inherit pkgconfig
inherit cmake

SRC_URI = "git://github.com/tdlib/td;branch=master;protocol=https"
SRCREV = "b3ab664a18f8611f4dfcd3054717504271eeaa7a"

S = "${WORKDIR}/git"
PV = "1.8.0+git"

EXTRA_OECMAKE:apppend = " -DCMAKE_BUILD_TYPE=Release"
OECMAKE_GENERATOR = "Unix Makefiles"

FILES:${PN} += " \
    ${libdir} \
"
