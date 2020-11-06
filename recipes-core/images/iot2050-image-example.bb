#
# Copyright (c) Siemens AG, 2019
#
# Authors:
#  Su Baocheng <baocheng.su@siemens.com>
#
# This file is subject to the terms and conditions of the MIT License.  See
# COPYING.MIT file in the top-level directory.
#

require recipes-core/images/iot2050-image-base.bb

DESCRIPTION = "IOT2050 Debian Example Image"

DEPENDS += "openssl"

# debug tools
IOT2050_DEBIAN_DEBUG_PACKAGES = " \
    busybox \
    bash-completion \
    less \
    vim \
    psmisc \
    bsdmainutils \
    haveged \
    nano \
    ifupdown \
    iputils-ping \
    ssh \
    pciutils \
    usbutils \
    ethtool \
    rt-tests \
    stress-ng \
    build-essential \
    gawk \
    curl \
    wget \
    ca-certificates \
    resolvconf \
    gdb \
    gdbserver \
    network-manager \
    modemmanager \
    ppp \
    isc-dhcp-client \
    cmake \
    autoconf \
    autotools-dev \
    rsyslog \
    net-tools \
    i2c-tools \
    sudo \
    docker.io \
    "

# wifi support
IOT2050_DEBIAN_WIFI_PACKAGES = " \
    iw \
    wpasupplicant \
    firmware-iwlwifi \
    "

# bluetooth support
IOT2050_DEBIAN_BT_PACKAGES = " \
    bluez \
    pulseaudio-module-bluetooth \
    "
# alsa support
IOT2050_DEBIAN_ALSA_PACKAGES = " \
    alsa-utils \
    alsa-tools \
    "
IMAGE_PREINSTALL += " \
    ${IOT2050_DEBIAN_DEBUG_PACKAGES} \
    ${IOT2050_DEBIAN_WIFI_PACKAGES} \
    ${IOT2050_DEBIAN_BT_PACKAGES} \
    ${IOT2050_DEBIAN_ALSA_PACKAGES} \
    "

IMAGE_INSTALL += " \
    expand-on-first-boot \
    sshd-regen-keys \
    regen-rootfs-uuid \
    switchserialmode \
    iot2050setup \
    iot2050-firmware-update \
    tcf-agent \
    mraa \
    "
