DESCRIPTION = "SHR Configuration for frameworkd."
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de> et. al."
SECTION = "console/network"
DEPENDS = "python-cython-native python-pyrex-native"
LICENSE = "GPL"
PV = "0.8.4.4+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=stabilization/milestone4 \
           file://frameworkd.conf"
S = "${WORKDIR}/git"

PROVIDES = "frameworkd-config"
RPROVIDES = "frameworkd-config"

do_install_append() {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/frameworkd.conf ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/freesmartphone/opreferences/schema/
	install -d ${D}${sysconfdir}/freesmartphone/opreferences/conf/profiles/
	install -d ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/
	install -d ${D}${sysconfdir}/freesmartphone/opreferences/conf/rules/
	install -d ${D}${sysconfdir}/freesmartphone/oevents/
	install -d ${D}${sysconfdir}/freesmartphone/persist/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/schema/phone.yaml ${D}${sysconfdir}/freesmartphone/opreferences/schema/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/schema/profiles.yaml ${D}${sysconfdir}/freesmartphone/opreferences/schema/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/schema/rules.yaml ${D}${sysconfdir}/freesmartphone/opreferences/schema/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/conf/profiles/default.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/profiles/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/conf/phone/default.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/conf/phone/silent.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/conf/rules/default.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/rules/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/conf/rules/silent.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/rules/
	install -m 0644 ${S}/etc/freesmartphone/oevents/rules.yaml ${D}${sysconfdir}/freesmartphone/oevents/
	install -m 0644 ${S}/etc/freesmartphone/persist/README ${D}${sysconfdir}/freesmartphone/persist/
}

PACKAGE_ARCH_${PN} = "${MACHINE_ARCH}"

FILES_${PN} = "\
  ${sysconfdir}/frameworkd.conf \
  ${sysconfdir}/freesmartphone \
"
CONFFILES_${PN} = "\
  ${sysconfdir}/frameworkd.conf \
  ${sysconfdir}/freesmartphone/opreferences/conf/phone/silent.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/profiles/default.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/rules/silent.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/rules/default.yaml \
  ${sysconfdir}/freesmartphone/oevents/rules.yaml \
"
