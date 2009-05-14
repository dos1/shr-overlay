DESCRIPTION = "GLib-based DBus bindings for freesmartphone.org - Vala implementation"
AUTHOR = "Didier 'Ptitjes"

PV = "0.0.1-gitr${SRCREV}"
PR = "r0"

DEPENDS = "vala-native fso-specs"

SRC_URI = "git://git.freesmartphone.org/libfso-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit pkgconfig autotools

do_configure() {
	export SPECS_PATH="${STAGING_DATADIR}/fso-specs" 
	${S}/autogen.sh
}


