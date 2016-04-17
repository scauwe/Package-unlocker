/*******************************************************************************
 * Copyright (c) 2014-2016 Stefaan Van Cauwenberge
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0 (the "License"). If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *  	 
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Initial Developer of the Original Code is
 * Stefaan Van Cauwenberge. Portions created by
 *  the Initial Developer are Copyright (C) 2007-2015 by
 * Stefaan Van Cauwenberge. All Rights Reserved.
 *
 * Contributor(s): none so far.
 *    Stefaan Van Cauwenberge: Initial API and implementation
 *******************************************************************************/
package info.vancauwenberge.idm.action;

import com.novell.core.util.Log;
import com.novell.core.Core;
import com.novell.idm.actions.LibraryAction;
import com.novell.idm.model.IdmPackage;
import com.novell.idm.packages.PackageVersion;

public class GetPackageChangeLogAction extends LibraryAction
{
  private IdmPackage selectedPackage;

  protected void performAction()
  {
    if ((this.m_selection != null) && (this.m_selection.size() > 0)) 
    {
    	Object element = this.m_selection.getFirstElement();
    	if (element instanceof IdmPackage)
    	{
    		this.selectedPackage = ((IdmPackage)element);
    	    markNotImported();
    		return;
    	}
    }
    Log.error("GetPackageChangeLogAction may only be enabled on a package object");
    return;
  }

  private int markNotImported(){
	  Core.infoDlg(selectedPackage.getChangeLog());
	  return 0;
  }

  protected int performAction(IdmPackage paramIdmPackage)
  {
    this.selectedPackage = paramIdmPackage;
    return markNotImported();
  }

  protected void performActionNoWizard(IdmPackage paramIdmPackage, PackageVersion paramPackageVersion)
  {
    this.selectedPackage = paramIdmPackage;
    markNotImported();
  }
}