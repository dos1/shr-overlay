# PREFERRED_PROVIDER_frameworkd = "frameworkd-devel"

# libeflvala needs at least 2.18.0 and upstream OE provides only 2.16.4
PREFERRED_VERSION_glib-2.0 = "2.18.3"

# FSO stuff
SRCREV_pn-frameworkd = "${AUTOREV}"
SRCREV_pn-frameworkd-config-shr = "${AUTOREV}"
SRCREV_pn-libeflvala = "4b7440b08b96831da5cc2ef657af76ae20f3065a"
SRCREV_pn-frameworkd-config-shr = "${AUTOREV}"
SRCREV_pn-frameworkd-config-shr_FSO_REV = "${AUTOREV}"
SRCREV_pn-frameworkd-config-shr_SHR_REV = "${AUTOREV}"
SRCREV_pn-vala-terminal = "2f849c5690d8"
SRCREV_pn-vala-dbus-binding-tool = "${AUTOREV}"
SRCREV_pn-libfso-glib = "${AUTOREV}"

# SHR stuff
SRCREV_pn-shr-settings = "${AUTOREV}"
SRCREV_pn-shr-theme = "${AUTOREV}"
SRCREV_pn-libframeworkd-glib = "${AUTOREV}"
SRCREV_pn-ophonekitd = "${AUTOREV}"
SRCREV_pn-shr-messages = "${AUTOREV}"
SRCREV_pn-shr-contacts = "${AUTOREV}"
SRCREV_pn-shr-dialer = "${AUTOREV}"
SRCREV_pn-libframeworkd-phonegui-efl = "${AUTOREV}"
SRCREV_pn-libframeworkd-phonegui-efl2 = "${AUTOREV}"
SRCREV_pn-libframeworkd-phonegui = "${AUTOREV}"
SRCREV_pn-libhito = "${AUTOREV}"
SRCREV_pn-neod = "${AUTOREV}"
SRCREV_pn-libframeworkd-phonegui-gtk = "${AUTOREV}"
PREFERRED_VERSION_calc = "0.0.1"
#pin shr-config due to gnome bug 579803 (requires vala > 0.7.1)
SRCREV_pn-shr-config = "9b59390d265805b68ea10136fa03fa67713f1275"

EFL_SRCREV = "39827"
SRCREV_pn-python-elementary = "39834"

# KERNEL
SRCREV_pn-linux-openmoko-2.6.28 = "${AUTOREV}"
SRCREV_pn-linux-eten = "df9715883efa3e6a88866813168fabb1c16b0b7a"

# other stuff
SRCREV_pn-openmoocow = "${AUTOREV}"
SRCREV_pn-libmokoui2 = "4695"

#PREFERRED_VERSION_fakeroot = "1.12.1"
#PREFERRED_VERSION_fakeroot-native = "1.12.1"

SRCREV_pn-boost-signals2 = "52299"
SRCREV_pn-dbus-c++-native = "${AUTOREV}"
SRCREV_pn-dbus-c++ = "${AUTOREV}"
