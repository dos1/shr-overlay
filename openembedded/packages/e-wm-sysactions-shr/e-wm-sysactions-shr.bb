DESCRIPTION = "illume SHR sysactions config"
SECTION = "e/utils"
LICENSE = "MIT BSD"
PV = "1.0-${EFL_SRCREV}"
PR = "r2"

RPROVIDES_${PN} = "e-wm-sysactions"
RCONFLICTS_${PN} = "e-wm-sysactions"

SRC_URI = "\
  file://sysactions.conf  \
  file://suspend.sh"

S = "${WORKDIR}/"

FILES_${PN} = "${sysconfdir}/enlightenment"

do_install() {
    install -d ${D}${sysconfdir}/enlightenment/
    install -m 0755 ${WORKDIR}/sysactions.conf ${D}${sysconfdir}/enlightenment/sysactions.conf
    install -m 0755 ${WORKDIR}/suspend.sh ${D}${sysconfdir}/enlightenment/suspend.sh
}
