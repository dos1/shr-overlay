DESCRIPTION = "Standard icon theme for the SHR distribution"
SECTION = "x11/data"
PV = "0.0.1+gitr${SRCREV}"
PR = "r1"

inherit shr autotools

# S = "${WORKDIR}/icons"

pkg_postinst_shr-theme () {
}

PACKAGE_ARCH = "all"

