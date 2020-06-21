SUMMARY = "Droid plugin for GStreamer"
HOMEPAGE = "https://github.com/sailfishos/gst-droid"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

inherit autotools pkgconfig

# Depends on libhybris which has this restriction
COMPATIBLE_MACHINE = "^halium$"

SRC_URI = "git://github.com/sailfishos/gst-droid.git;protocol=https \
           file://0001-Remove-references-to-mode-that-are-not-in-upstream-g.patch \
           file://gstdroidcodec.conf \
"
#too recent, issues with buffer pool
#SRCREV = "e755c8521b3ff0a622fba4c85e57ff41015c7793" 
#PV = "20200424+git${SRCPV}"

SRCREV = "1d3c3cd93340a50559424450f0941d42c95de5f7"
PV = "20200220+git${SRCPV}"

S = "${WORKDIR}/git"
B = "${S}"

DEPENDS += "gstreamer1.0 gstreamer1.0-plugins-bad gstreamer1.0-plugins-base libhybris droidmedia gettext-native nemo-gst-interfaces libexif"

do_configure_prepend() {
    sed -i "s@/usr/share/droidmedia/hybris.c@${STAGING_INCDIR}/droidmedia/hybris.c@" gst-libs/gst/droid/Makefile.am gst/Makefile.am
    sed -i "s@I/usr/include/droidmedia/@I${STAGING_INCDIR}/droidmedia/@" gst/droidcamsrc/Makefile.am gst/droideglsink/Makefile.am gst/droidcodec/Makefile.am gst/Makefile.am gst-libs/gst/droid/Makefile.am
    NOCONFIGURE=1 ${S}/autogen.sh
}

do_install_append() {
    install -d ${D}/etc/gst-droid
    install -m 0644 ${WORKDIR}/gstdroidcodec.conf ${D}/etc/gst-droid/gstdroidcodec.conf
}

FILES_${PN} += "/usr/lib/gstreamer-1.0/libgstdroid.so /etc/gst-droid/gstdroidcodec.conf"
FILES_${PN}-staticdev += "/usr/lib/gstreamer-1.0/libgstdroid.a"
