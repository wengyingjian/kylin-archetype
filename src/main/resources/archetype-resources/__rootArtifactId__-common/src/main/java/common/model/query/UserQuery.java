#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.model.query;

import com.wengyingjian.kylin.common.model.query.PageQuery;


/**
 * Created by wengyingjian on 16/2/1.
 */
public class UserQuery extends PageQuery {

    private Integer id;
    private Integer type;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}