SUMMARY = "Libhybris wrapper for libdroidmedia"
HOMEPAGE = "https://github.com/sailfishos/droidmedia"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

# Depends on libhybris which has this restriction
COMPATIBLE_MACHINE = "^halium$"

SRC_URI = "git://github.com/sailfishos/droidmedia.git;protocol=https"
#SRCREV = "80de4445c86df576d6458be256d7907652016df2"
#PV = "20200424+git${SRCPV}"

SRCREV = "52143f26ff6dc2346cf4f14792c175493cf529b1"
PV = "20191025+git${SRCPV}"


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
