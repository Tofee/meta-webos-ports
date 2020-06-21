FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-Add-a-control-which-allows-overriding-the-gstreamer-.patch  \
    file://0002-qtmultimedia-fix-capsForFormats-to-generate-caps-per.patch  \
    file://0003-nemo-Add-support-for-camera-torch-mode.patch                \
    file://0004-nemo-Add-basic-ready-for-capture-handling-to-CameraB.patch  \
    file://0005-nemo-gstreamer-take-into-account-ready-for-capture-p.patch  \
    file://0006-Account-for-errors-reported-by-camera-source.-Contri.patch  \
    file://0007-QCamera-select-default-device-if-no-name-given.patch        \
"
