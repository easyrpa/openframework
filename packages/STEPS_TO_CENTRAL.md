## Create a ticket with Sonatype
* [Create Jira account](https://issues.sonatype.org/secure/Signup!default.jspa)
* [Create a New Project ticket](https://issues.sonatype.org/secure/Signup!default.jspa). Note "_This triggers creation of your repositories. Normally, the process takes less than 2 business days._"

## Review Requirements
Use the parent pom.xml as template, [link](https://github.com/dkatkov-moon/openframework/blob/dkatkov-maven-central/packages/pom.xml)
Or go through requirements below and fix them:
* [Supply Javadoc and Sources](https://central.sonatype.org/publish/requirements/#supply-javadoc-and-sources)
* [Sign Files with GPG/PGP](https://central.sonatype.org/publish/requirements/#sign-files-with-gpgpgp). Step-by-step instructions in next section.
* [Sufficient Metadata](https://central.sonatype.org/publish/requirements/#sufficient-metadata)
* [Correct Coordinates](https://central.sonatype.org/publish/requirements/#correct-coordinates)
* [Project Name, Description and URL](https://central.sonatype.org/publish/requirements/#project-name-description-and-url)
* [License Information](https://central.sonatype.org/publish/requirements/#license-information)

## Configure GPG
* Here is instructions from Sonatype guide (https://central.sonatype.org/publish/requirements/gpg/) using **gpg command line**.
  I didn't manage to get success using version 2.3.4, had to download the GPG4Win bundle version 4.0.0
* Download link to GnuPG packages is (https://gnupg.org/download/index.html#sec-1-2), for Windows use the following direct link to GPG4Win on Windows [download link](https://gpg4win.org/thanks-for-download.html), as general download link asks for donation.
  Steps below only for GPG4Win v4:
    * Launch Kleopatra application after installation of GPG4Win.
    * Select File -> New Key Pair -> Create a personal OpenGPG key pair
    * Specify Name and Email fields, and take a look to **Advanced Settings**, there is option to set usage limit by valid until - for example 2 years
    * Tick **Protect the generated key with a passphrase** and click **Create** button
    * When pair is generated, then select it and choose **Publish on Server** option -> you should get **OpenGPG certificates exported successfully**
* Use the parent pom.xml as template or manually go through next topic [Deploying to OSSRH with Apache Maven - Introduction](https://central.sonatype.org/publish/publish-maven/#deploying-to-ossrh-with-apache-maven-introduction)
  As result you should get automatically signed "jar" files on maven verify stage, for example:
  `easy-rpa-openframework-core-1.0.0-SNAPSHOT.jar.asc
  easy-rpa-openframework-core-1.0.0-SNAPSHOT-javadoc.jar.asc
  easy-rpa-openframework-core-1.0.0-SNAPSHOT-sources.jar.asc`
  
## Releasing Deployment from OSSRH to the Central Repository
* [Introduction](https://central.sonatype.org/publish/release/#releasing-deployment-from-ossrh-to-the-central-repository-introduction)


Based on:
[The Central Repository Documentation - Publish Guide](https://central.sonatype.org/publish/publish-guide/)
[Apache Maven Project - Guide to uploading artifacts to the Central Repository](https://maven.apache.org/repository/guide-central-repository-upload.html)
[Habr - Публикация артефакта в Maven Central через Sonatype OSS Repository Hosting Service](https://habr.com/ru/post/171493/)
