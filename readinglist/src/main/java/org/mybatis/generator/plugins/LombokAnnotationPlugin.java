/**
 * 
 */
package org.mybatis.generator.plugins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import lombok.Data;

/**
 * @author cdz lombok plugin
 *
 */
public class LombokAnnotationPlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		topLevelClass.addAnnotation("@Data");
//		topLevelClass.addAnnotation("@EqualsAndHashCode(callSuper = false)");
		topLevelClass.addImportedType("lombok.Data");
//		topLevelClass.addImportedType("lombok.EqualsAndHashCode");
		return super.modelPrimaryKeyClassGenerated(topLevelClass, introspectedTable);
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//		List<Method> methods = topLevelClass.getMethods();
//		topLevelClass.addTypeParameter(new TypeParameter("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
//		topLevelClass.addTypeParameter(new TypeParameter("BBBBBBBBBBBB"));
//		List<Method> remove = new ArrayList<>();
		topLevelClass.addAnnotation("@Data");
//		topLevelClass.addAnnotation("@EqualsAndHashCode(callSuper = true)");
		topLevelClass.addAnnotation("@EqualsAndHashCode");
		topLevelClass.addImportedType("lombok.Data");
		topLevelClass.addImportedType("lombok.EqualsAndHashCode");
//		Iterator<Method> iterator = methods.iterator();
//		while (iterator.hasNext()) {
//			Method method = iterator.next();
//			if (method.getName().startsWith("get") || method.getName().startsWith("set")) {
//				iterator.remove();
//			}
//		}
//		for (Method method : methods) {
//			if (method.getName().startsWith("get") || method.getName().startsWith("set")) {
////				if (method.getBodyLines().size() < 2) {
//				remove.add(method);
//			}
//		}
//		methods.removeAll(remove);
		return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
	}

	@Override
	public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		topLevelClass.addAnnotation("@Data");
		topLevelClass.addAnnotation("@EqualsAndHashCode(callSuper = true)");
		topLevelClass.addImportedType("lombok.Data");
		topLevelClass.addImportedType("lombok.EqualsAndHashCode");
		return super.modelRecordWithBLOBsClassGenerated(topLevelClass, introspectedTable);
	}

	public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
		return false;
	}

	@Override
	public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
		return false;
	}
}
