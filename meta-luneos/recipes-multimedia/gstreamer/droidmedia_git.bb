SUMMARY = "Libhybris wrapper for libdroidmedia"
HOMEPAGE = "https://github.com/sailfishos/droidmedia"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

# Depends on libhybris which has this restriction
COMPATIBLE_MACHINE = "^halium$"

SRC_URI = "git://github.com/sailfishos/droidmedia.git;protocol=https"

SRCREV = "d0d14dd9853ed41d5fc7196a65e0453b7fa0f3b6"
PV = "20210203+git${SRCPV}"


DEPENDS = "libhybris"

do_compile() {
    mkdir ${WORKDIR}/build
    cp ${WORKDIR}/git/hybris.c ${WORKDIR}/build/hybris.c
    sed -i "s@/usr/libexec/droid-hybris/system/lib/@/system/lib64/@" ${WORKDIR}/build/hybris.c
}

do_install() {
    install -d ${D}${includedir}/droidmedia
    install -m 0644 ${WORKDIR}/build/hybris.c ${D}${includedir}/droidmedia/hybris.c
    install -m 0644 ${WORKDIR}/git/*.h ${D}${includedir}/droidmedia/
}

FILES_${PN}-dev = "${includedir}/droidmedia"
