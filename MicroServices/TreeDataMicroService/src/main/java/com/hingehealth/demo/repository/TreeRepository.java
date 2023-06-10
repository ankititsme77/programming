package com.hingehealth.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hingehealth.demo.model.Node;

@Repository
public interface TreeRepository extends JpaRepository<Node, String> {

	@Query("SELECT n FROM TreeNode n WHERE n.id = :id")
	Node findNodeById(String id);

	@Modifying
	@Transactional
	@Query("INSERT INTO TreeNode (id, label) VALUES (:id, :label , :parent_id)")
	void addNode(String id, String label, String parent_id);


	@Query("SELECT n FROM TreeNode n LEFT JOIN FETCH n.children")
	List<Node> getTreeData();
}