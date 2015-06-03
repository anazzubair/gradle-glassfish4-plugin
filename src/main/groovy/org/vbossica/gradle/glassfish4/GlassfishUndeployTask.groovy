/*
 * Copyright 2011-2012 Vladimir Ritz Bossicard
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vbossica.gradle.glassfish4

/**
 * @author vladimir
 */
class GlassfishUndeployTask extends AbstractGlassfishTask {

  String targetName

  protected void process(GlassfishPluginConvention convention) {

    def authArgs = [
        user: convention.userName,
        port: convention.adminPort,
        // passwordfile: convention.passwordFile,
        // host: convention.host,
    ]

    def name = targetName != null ? targetName : convention.targetName

    def authArguments = formatArgs(authArgs, ' ')

    execute("${convention.asadminExec} ${authArguments} undeploy ${name}")
  }

}
