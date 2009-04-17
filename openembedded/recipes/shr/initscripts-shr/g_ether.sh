#!/bin/sh

# This script runs very early in order to ensure that the
# usb0 networking interface comes up at first system boot.

# Gather up all g_ether parameters passed in on the kernel
# command line, and make sure to pass them to the module;
# this will ensure similar behavior between the module and
# built-in.
#
# Here's a sample command line from a newer Qi:
#
#loglevel=4 console=tty0 console=ttySAC2,115200 init=/sbin/init ro
# mtdparts=physmap-flash:-(nor);neo1973-nand:0x00040000(qi),
#0x00040000(depr-ub-env),0x00800000(kernel),0x000a0000(depr),
#0x00040000(identity-ext2),0x0f6a0000(rootfs)
# g_ether.host_addr=00:1F:11:01:1D:A9 g_ether.dev_addr=00:1F:11:01:1D:A9
# rootfstype=jffs2 root=/dev/mtdblock6

c=`cat /proc/cmdline`
for a in $c; do
  p="$p `echo "$a" | sed -n -e 's/^g_ether\.\(.*\)$/\1/p'`"
done

echo "modprobe: g_ether $p"

modprobe g_ether $p 2>/dev/null || true
