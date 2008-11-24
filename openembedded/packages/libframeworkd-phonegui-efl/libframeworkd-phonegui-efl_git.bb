DESCRIPTION = "frameworkd EFL phonegui"
SECTION = "openmoko/pim"
PKG_TAGS_${PN} = "group::communication"
DEPENDS += " dbus-glib libframeworkd-glib etk evas ecore edje edje-native elementary"
PV = "0.0.1+${PR}-gitr${SRCREV}"
PR = "r25"

inherit shr pkgconfig autotools

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

do_stage () {
        oe_libinstall -so libframeworkd-phonegui-efl ${STAGING_LIBDIR}
        autotools_stage_includes
}