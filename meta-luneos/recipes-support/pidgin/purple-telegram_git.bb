SUMMARY = "Telegram protocol plug-in for libpurple"
SECTION = "webos/services"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

DEPENDS = "pidgin json-glib glib-2.0 zlib tdlib"

inherit pkgconfig
inherit cmake

SRC_URI = "git://github.com/BenWiederhake/tdlib-purple;branch=master;protocol=https"
SRCREV = "43e6cc2f14ccd08171b1515f6216f4bbf84eed80"

S = "${WORKDIR}/git"
PV = "0.8.1+git"

EXTRA_OECMAKE += "-DNoWebp:BOOL=TRUE -DNoLottie:BOOL=TRUE -DNoVoip:BOOL=TRUE"

FILES:${PN} += " \
    ${libdir} \
"
