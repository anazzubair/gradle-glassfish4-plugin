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

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author vladimir
 */
class GlassfishPlugin implements Plugin<Project> {

  def void apply(Project project) {
    project.convention.plugins.glassfish4 = new GlassfishPluginConvention()

    GlassfishCreateDomainTask createTask = project.getTasks().create("createDomain", GlassfishCreateDomainTask.class)
    createTask.group = 'Glassfish4'
    createTask.description = 'Creates a Glassfish4 domain.'

    GlassfishDeleteDomainTask deleteTask = project.getTasks().create("deleteDomain", GlassfishDeleteDomainTask.class)
    deleteTask.group = 'Glassfish4'
    deleteTask.description = 'Deletes the Glassfish4 domain.'

    GlassfishStartDomainTask startTask = project.getTasks().create("startDomain", GlassfishStartDomainTask.class)
    startTask.group = 'Glassfish4'
    startTask.description = 'Starts the Glassfish4 domain.'

    GlassfishStopDomainTask stopTask = project.getTasks().create("StopDomain", GlassfishStopDomainTask.class)
    stopTask.group = 'Glassfish4'
    stopTask.description = 'Stops the Glassfish4 domain.'

    GlassfishDeployTask deployTask = project.getTasks().create("deployApp", GlassfishDeployTask.class)
    deployTask.group = 'Glassfish4'
    deployTask.description = 'Deploys the application onto the Glassfish4 domain.'

    GlassfishUndeployTask undeployTask = project.getTasks().create("undeployApp", GlassfishUndeployTask.class)
    undeployTask.group = 'Glassfish4'
    undeployTask.description = 'Undeploys the application from the Glassfish4 domain.'
  }

}