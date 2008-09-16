#------------------------------------------------------
# SHR Image Recipe
#------------------------------------------------------

IMAGE_LINGUAS = ""

# getting the base system up
BASE_INSTALL = "\
  ${MACHINE_TASK_PROVIDER} \
  netbase \
  sysfsutils \
  module-init-tools-depmod \
  rsync \
  screen \
  fbset \
  fbset-modes \
"
# Some machines don't set a *runtime* provider for X, so default to Xfbdev here
# virtual/xserver won't work, since the kdrive recipes will build
# multiple xserver packages
XSERVER ?= "xserver-kdrive-fbdev"

ILLUME_INSTALL = "\
  e-wm \
  illume \
  illume-config-illume \
  illume-dicts-english-us \
  illume-keyboards-default \
  illume-keyboards-numbers \
  illume-keyboards-terminal \
  illume-theme-freesmartphone \
"

# getting an X window system up
X_INSTALL = "\
  ${ILLUME_INSTALL} \
  ${XSERVER} \
  xserver-kdrive-common \
  xserver-nodm-init \
  xauth \
  xhost \
  xset \
  xrandr \
  \
  fontconfig-utils \
  \
  ttf-dejavu-common \
  ttf-dejavu-sans \
  ttf-dejavu-serif \
  \
"

# useful command line tools
TOOLS_INSTALL = "\
#  bash \
  dosfstools \
  iptables \
  lsof \
  mickeydbus \
  mickeyterm \
  mtd-utils \
  nano \
  powertop \
  s3c24xx-gpio \
  sysstat \
"

# audio
AUDIO_INSTALL = "\
  alsa-oss \
  alsa-state \
  alsa-utils-aplay \
  alsa-utils-amixer \
  gst-meta-audio \
  gst-plugin-mad \
  gst-plugin-modplug \
  gst-plugin-sid \
  fso-sounds \
"

GTK_INSTALL = "\
  hicolor-icon-theme \
  openmoko-theme-standard2 \
  openmoko-icon-theme-standard2 \
  openmoko-calculator2 \
  openmoko-terminal2 \
  gpe-scap \
  tangogps-fso \
"

GAMES_INSTALL = "\
  numptyphysics \
"

# FIXME these should rather be part of alsa-state,
# once Om stabilizes them...
AUDIO_INSTALL_append_om-gta01 = "\
  openmoko-alsa-scenarios \
"
AUDIO_INSTALL_append_om-gta02 = "\
  openmoko-alsa-scenarios \
"

# python
PYTHON_INSTALL = "\
  task-python-efl \
  python-codecs \
  python-gst \
"

# zhone
ZHONE_INSTALL = "\
  gsm0710muxd \
  frameworkd \
  zhone \
"

# SHR
SHR_INSTALL = "\
  frameworkd \
  libhito \
  libframeworkd-glib \
  libframeworkd-phonegui-gtk \
  openmoko-dialer3 \
"

IMAGE_INSTALL = "\
  ${BASE_INSTALL} \
  ${X_INSTALL} \
  ${GTK_INSTALL} \
  ${GAMES_INSTALL} \
  ${AUDIO_INSTALL} \
  ${TOOLS_INSTALL} \
  ${PYTHON_INSTALL} \
  ${SHR_INSTALL} \
#  ${ZHONE_INSTALL} \
"

inherit image

# perform some FSO convenience tweaks to the rootfs
fso_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    # date/time
    date "+%m%d%H%M%Y" >./etc/timestamp
    # alias foo
    echo "alias pico=nano" >>./etc/profile
    echo "alias fso='cd /local/pkg/fso'" >>./etc/profile
    echo "alias ipkg='opkg'" >>./etc/profile
    # nfs
    mkdir -p ./local/pkg
    echo >>./etc/fstab
    echo "# NFS Host" >>./etc/fstab
    echo "192.168.0.200:/local/pkg /local/pkg nfs noauto,nolock,soft,rsize=32768,wsize=32768 0 0" >>./etc/fstab
    # fix .desktop files for illume
    desktop=`find ./usr/share/applications -name "*.desktop"`
    for file in $desktop; do
        echo "Categories=Office;" >>$file
    done
    # minimal gtk theme foo
    mkdir -p ./etc/gtk-2.0/
    echo 'gtk-font-name = "Sans 5"' >> ./etc/gtk-2.0/gtkrc
    # fix strange iconv/gconf bug
    ln -s libc.so.6 ./lib/libc.so
    cd $curdir
}

# perform some SHR convenience tweaks to the rootfs
shr_rootfs_postprocess() {
    dirs=`find ${FILESDIR} -type d -printf "%P\n" | grep -v "^.$" | grep -v ".svn"`
    for dir in $dirs; do
        mkdir -p ${IMAGE_ROOTFS}/$dir
    done
    files=`find ${FILESDIR} -type f -printf "%P\n" | grep -v ".svn"`
    for file in $files; do
        cp -f ${FILESDIR}/$file ${IMAGE_ROOTFS}/$file
    done

    curdir=$PWD
    cd ${IMAGE_ROOTFS}

    # set openmoko theme
    mkdir -p ./etc/gtk-2.0/
    echo 'gtk-theme-name = "openmoko-standard-2"' >> ./etc/gtk-2.0/gtkrc
    echo 'gtk-icon-theme-name = "openmoko-standard"' >> ./etc/gtk-2.0/gtkrc

    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "fso_rootfs_postprocess; shr_rootfs_postprocess"
