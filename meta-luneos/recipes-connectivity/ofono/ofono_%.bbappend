FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCREV = "0ff8608ac318938aaf9735746b5209ea8058ac8e"
PV = "1.19+git${SRCPV}"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a"

DEPENDS += "libglibutil dbus-glib"
RDEPENDS_${PN} += "mobile-broadband-provider-info ofono-conf"

SRC_URI  = " \
  git://git.merproject.org/mer-core/ofono.git;protocol=git;branch=master \
  file://0001-Enable-the-various-modem-plugins-we-support-again.patch;striplevel=2 \
  file://0002-Add-support-for-the-Ericsson-F5521gw-modem.patch;striplevel=2 \
  file://0003-configure.ac-always-require-libglibutil.patch;striplevel=2 \
  file://ofono \
  file://ofono.service \
"

S = "${WORKDIR}/git/ofono"

# Can't build out of tree right now so we have to build in tree
B = "${S}"

EXTRA_OECONF_append = " --disable-sailfish-pushforwarder"

do_install_append() {
    # Override default system service configuration
    cp -v ${WORKDIR}/ofono.service ${D}${systemd_unitdir}/system/ofono.service
}

# meta-systemd sets this to disable but we as distro want it to be enabled by default
SYSTEMD_AUTO_ENABLE_forcevariable = "enable"

RDEPENDS_${PN}-tests += "python"
