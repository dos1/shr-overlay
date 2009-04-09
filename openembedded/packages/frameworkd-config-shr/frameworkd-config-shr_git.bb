DESCRIPTION = "SHR Configuration for frameworkd."
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de> et. al."
SECTION = "console/network"
DEPENDS = "python-cython-native python-pyrex-native"
LICENSE = "GPL"
PV = "0.8.5.1+gitr${SRCREV}"
PR = "r3"

SRC_URI = "${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=master \
           file://frameworkd.conf \
           file://rules.yaml \
           file://profiles
           file://ringtone_ringnroll.wav "
S = "${WORKDIR}/git"

PROVIDES = "frameworkd-config"
RPROVIDES = "frameworkd-config"

do_install_append() {
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/freesmartphone/opreferences/schema/
	install -d ${D}${sysconfdir}/freesmartphone/opreferences/conf/profiles/
	install -d ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/
	install -d ${D}${sysconfdir}/freesmartphone/opreferences/conf/rules/
	install -d ${D}${sysconfdir}/freesmartphone/oevents/
	install -d ${D}${sysconfdir}/freesmartphone/ogsmd/
	install -d ${D}${sysconfdir}/freesmartphone/persist/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/schema/phone.yaml ${D}${sysconfdir}/freesmartphone/opreferences/schema/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/schema/profiles.yaml ${D}${sysconfdir}/freesmartphone/opreferences/schema/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/schema/rules.yaml ${D}${sysconfdir}/freesmartphone/opreferences/schema/
	install -m 0644 ${S}/etc/freesmartphone/persist/README ${D}${sysconfdir}/freesmartphone/persist/
	install -m 0644 ${S}/etc/freesmartphone/ogsmd/networks.tab ${D}${sysconfdir}/freesmartphone/ogsmd/

        # Install SHR custom files
        install -m 0644 ${WORKDIR}/frameworkd.conf ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/rules.yaml ${D}${sysconfdir}/freesmartphone/oevents/
        install -m 0644 ${WORKDIR}/profiles/profiles/default.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/profiles/

        install -m 0644 ${WORKDIR}/profiles/phone/default.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/
        install -m 0644 ${WORKDIR}/profiles/rules/default.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/rules/

        install -m 0644 ${WORKDIR}/profiles/phone/ring.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/
        install -m 0644 ${WORKDIR}/profiles/rules/ring.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/rules/

        install -m 0644 ${WORKDIR}/profiles/phone/vibrate.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/
        install -m 0644 ${WORKDIR}/profiles/rules/vibrate.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/rules/

        install -m 0644 ${WORKDIR}/profiles/phone/silent.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/
        install -m 0644 ${WORKDIR}/profiles/rules/silent.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/rules/

        install -d ${D}${datadir}/sounds
        install -m 0644 ${WORKDIR}/ringtone_ringnroll.wav ${D}${datadir}/sounds/
}

PACKAGE_ARCH_${PN} = "${MACHINE_ARCH}"

FILES_${PN} = "\
  ${sysconfdir}/frameworkd.conf \
  ${sysconfdir}/freesmartphone \
  ${datadir}/sounds/ringtone_ringnroll.wav \
"
CONFFILES_${PN} = "\
  ${sysconfdir}/frameworkd.conf \
  ${sysconfdir}/freesmartphone/opreferences/conf/phone/silent.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/profiles/default.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/rules/silent.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/rules/default.yaml \
  ${sysconfdir}/freesmartphone/oevents/rules.yaml \
  ${sysconfdir}/freesmartphone/ogsmd/networks.tab \
"
