DESCRIPTION = "SHR Fat Image Feed"
PR = "r0"
PV = "1.0"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} += "\
    task-shr-apps \
    task-shr-games \
    task-shr-gtk \
"


