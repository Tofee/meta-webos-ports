SUMMARY = "Droid plugin for GStreamer"
HOMEPAGE = "https://github.com/sailfishos/gst-droid"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

inherit autotools pkgconfig

# Depends on libhybris which has this restriction
COMPATIBLE_MACHINE = "^halium$"

# Re-use all the patches from https://gitlab.com/ubports/core/packaging/gst-droid
# Make sure the patches' version match with gst-droid version !

SRC_URI = "git://github.com/sailfishos/gst-droid.git;protocol=https;name=gst-droid \
           git://git.sailfishos.org/mirror/gstreamer-common.git;protocol=https;name=gst-droid-common;destsuffix=git/common \
           git://gitlab.com/ubports/core/packaging/gst-droid.git;branch=ubports/xenial;protocol=https;name=gst-droid-packaging;destsuffix=git-gst-droid-packaging \
           file://gstdroidcodec.conf \
"

SRCREV_gst-droid = "f6a1b484cbbbd77a636cc860f38b5d77241e0a41"
SRCREV_gst-droid-common = "bcb1518c08c889dd7eda06936fc26cad85fac755"
SRCREV_gst-droid-packaging = "2f94cf7f42ef37fc607edb6f3938ee16de53bcb7"
PV = "20201104+git${SRCPV}"

SRCREV = "${SRCREV_gst-droid}"
SRCREV_FORMAT = "SRCREV_gst-droid"

S = "${WORKDIR}/git"
B = "${S}"

DEPENDS += "gstreamer1.0 gstreamer1.0-plugins-bad gstreamer1.0-plugins-base libhybris droidmedia gettext-native nemo-gst-interfaces libexif"

# Apply all the ubports/gst-droid-packaging patches
do_patch_append() {
    bb.build.exec_func('install_ubports_patches', d)
}
install_ubports_patches() {
    while read patchfile  
    do  
        echo "Applying patch $patchfile ..."
        ( cd ${S}; git apply ${WORKDIR}/git-gst-droid-packaging/debian/patches/$patchfile )
    done < ${WORKDIR}/git-gst-droid-packaging/debian/patches/series
}

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
