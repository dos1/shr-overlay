# PREFERRED_PROVIDER_frameworkd = "frameworkd-devel"

# libeflvala needs at least 2.18.0 and upstream OE provides only 2.16.4
PREFERRED_VERSION_glib-2.0 = "2.18.3"
PREFERRED_PROVIDER_e-wm-menu = "e-wm-menu"

# FSO stuff
SRCREV_pn-frameworkd = "${AUTOREV}"
SRCREV_pn-frameworkd-config-shr = "${AUTOREV}"
SRCREV_pn-libeflvala = "${AUTOREV}"

# SHR stuff
SRCREV_pn-shr-settings = "${AUTOREV}"
SRCREV_pn-shr-theme = "${AUTOREV}"
SRCREV_pn-libframeworkd-glib = "${AUTOREV}"
SRCREV_pn-ophonekitd = "${AUTOREV}"
SRCREV_pn-openmoko-messages3 = "${AUTOREV}"
SRCREV_pn-openmoko-contacts3 = "${AUTOREV}"
SRCREV_pn-openmoko-dialer3 = "${AUTOREV}"
SRCREV_pn-libframeworkd-phonegui-efl = "${AUTOREV}"
SRCREV_pn-libframeworkd-phonegui = "${AUTOREV}"
SRCREV_pn-libhito = "${AUTOREV}"
SRCREV_pn-neod = "${AUTOREV}"
SRCREV_pn-libframeworkd-phonegui-gtk = "${AUTOREV}"

SRCREV_pn-calc = "${AUTOREV}"
SRCREV_pn-vala-settings = "${AUTOREV}"

EFL_SRCREV = "39827"
SRCREV_pn-python-elementary = "39834"

# KERNEL
SRCREV_pn-linux-openmoko-2.6.28 = "${AUTOREV}"

# other stuff
SRCREV_pn-openmoocow = "${AUTOREV}"
PREFERRED_VERSION_vala-native = "0.6.0"

#PREFERRED_VERSION_fakeroot = "1.12.1"
#PREFERRED_VERSION_fakeroot-native = "1.12.1"

