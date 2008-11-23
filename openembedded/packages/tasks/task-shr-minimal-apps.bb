DESCRIPTION = "SHR Base Applications"
PR = "r1"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} = "\
  openmoko-dialer3 \
  openmoko-messages3 \
  openmoko-contacts3 \
  ophonekitd \ 
  libframeworkd-phonegui-efl \
  rxvt-unicode \
  elementary-alarm \
  shr-settings \
  shr-theme \
"
