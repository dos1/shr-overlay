DESCRIPTION = "Ophonekitd daemon"
SECTION = "x11/applications"
DEPENDS += " dbus-glib libframeworkd-glib libframeworkd-phonegui sqlite3"
SHR_PV = "0.0.1"
PR = "r12"

inherit shr autotools

SRC_URI += " file://80ophonekitd"

do_install_append() {
        install -d ${D}${sysconfdir}/X11/Xsession.d/
        install -d ${D}${sysconfdir}/dbus-1/system.d/
        install -d ${D}${datadir}/ophonekitd/
        install -m 0755 ${WORKDIR}/80ophonekitd ${D}${sysconfdir}/X11/Xsession.d/
        install -m 0755 ${S}/data/ophonekitd.conf ${D}${sysconfdir}/dbus-1/system.d/
        install -m 0755 ${S}/data/phonelog-database.sql ${D}${datadir}/ophonekitd/
}

pkg_postinst () {
        mkdir -p -m 755 /var/db
}

FILES_${PN} += "${datadir} ${sysconfdir}"

