DESCRIPTION = "SHR splash screen"
SECTION = "x11/data"
LICENSE = "MIT BSD"
PV = "1.0-gitr${SRCREV}"
PR = "r3"
DEPENDS += "initscripts"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/${PN}"

FILES_${PN} = "${datadir}/shr-splash \
	       ${sysconfdir}/init.d/shr-splash.sh \
	       ${sysconfdir}/rc0.d/S20shr-splash.sh \
	       ${sysconfdir}/rc6.d/S20shr-splash.sh \
	       ${sysconfdir}/rcS.d/S01shr-splash.sh \
"

do_install() {
    install -d ${D}${datadir}/shr-splash
    install -m 0755 ${S}/boot.fb ${D}${datadir}/shr-splash/boot.fb
    install -m 0755 ${S}/shutdown.fb ${D}${datadir}/shr-splash/shutdown.fb
    install -m 0755 ${S}/shr-splash.sh        ${D}${sysconfdir}/init.d
    ln -sf          ../init.d/shr-splash.sh         ${D}${sysconfdir}/rc0.d/S20shr-splash.sh
    ln -sf          ../init.d/shr-splash.sh         ${D}${sysconfdir}/rc6.d/S20shr-splash.sh
    ln -sf          ../init.d/shr-splash.sh         ${D}${sysconfdir}/rcS.d/S01shr-splash.sh
}
