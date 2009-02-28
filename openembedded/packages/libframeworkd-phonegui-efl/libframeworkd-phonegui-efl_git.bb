DESCRIPTION = "frameworkd EFL phonegui"
SECTION = "e/apps"
DEPENDS += " dbus-glib libframeworkd-glib libframeworkd-phonegui etk evas ecore edje edje-native elementary"
SHR_PV = "0.0.1"
PR = "r27"

inherit shr pkgconfig autotools

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

do_configure_prepend() {
        autopoint --force
}

do_stage () {
        oe_libinstall -so libframeworkd-phonegui-efl ${STAGING_LIBDIR}
        autotools_stage_includes
}

FILES_${PN} += "${datadir}/locale"
