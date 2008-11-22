DESCRIPTION = "SHR Base Applications"
PR = "r1"
LICENSE = "GPL"

inherit task

#XSERVER needs to be evaluated based on the MACHINE
PACKAGE_ARCH="${MACHINE_ARCH}"

RDEPENDS_${PN} = "\
  glibc-utils \
  glibc-charmap-utf-8 \
  e-wm \
  e-wm-config-illume \
  e-wm-config-standard \
  e-wm-config-minimalist \
  e-wm-config-scaleable \
  ${XSERVER} \
  xserver-kdrive-splash-illume \
  xserver-kdrive-common \
  xserver-nodm-init \
  xauth \
  xhost \
  xset \
  xrandr \
  fontconfig-utils \
  ttf-dejavu-common \
  ttf-dejavu-sans \
  exquisite \
  exquisite-themes \
  exquisite-theme-illume \
  ttf-dejavu-sans-mono \
"

#RDEPENDS_${PN}_append_om-gta02 = "\
#  ttf-arphic-uming \
#"
