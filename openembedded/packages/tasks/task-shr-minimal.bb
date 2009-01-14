DESCRIPTION = "SHR Lite Image Feed"
PR = "r0"
PV = "1.0"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} += "\
  ${MACHINE_TASK_PROVIDER} \
  task-base \
  task-shr-minimal-base \
  task-shr-minimal-apps \
  task-shr-minimal-audio \
  task-shr-minimal-gtk \
  task-shr-minimal-x \
  task-x11-illume \
  task-fso-compliance \
  task-cli-tools \
  task-cli-tools-python \
  task-fonts-truetype-core \
"


